import { useMutation } from '@tanstack/react-query'
import { Helmet } from 'react-helmet-async'
import { useForm } from 'react-hook-form'
import { useNavigate } from 'react-router-dom'
import { toast } from 'sonner'
import { z } from 'zod'

import { signIn } from '@/api/sign-in'
import { Button } from '@/components/ui/button'
import { Input } from '@/components/ui/input'
import { Label } from '@/components/ui/label'

const signInForm = z.object({
  username: z.string(),
  password: z.string(),
})

type SignInForm = z.infer<typeof signInForm>

export const SignIn = () => {
  const {
    register,
    handleSubmit,
    formState: { isSubmitting },
  } = useForm<SignInForm>()

  const navigate = useNavigate()

  const { mutateAsync: authenticate } = useMutation({
    mutationFn: signIn,
    onSuccess: (response) => {
      const accessToken = response.accessToken
      localStorage.setItem('accessToken', accessToken)
      navigate('/')
    },
  })

  const handleSignIn = async (data: SignInForm) => {
    try {
      await authenticate({ username: data.username, password: data.password })

      toast.success('Authentication successful.')
    } catch {
      toast.error('Error while trying to authenticate.')
    }
  }

  return (
    <>
      <Helmet title="Sign In" />
      <div className="p-8">
        <div className="flex w-[350px] flex-col justify-center gap-6">
          <div className="flex flex-col gap-2 text-center">
            <h1 className="text-2xl font-semibold tracking-tight">
              Access Employers Creator
            </h1>
            <p className="text-sml text-muted-foreground">
              Manage your Employees in the App!
            </p>
          </div>

          <form onSubmit={handleSubmit(handleSignIn)} className="space-y-4">
            <div className="space-y-2">
              <Label htmlFor="username">Username</Label>
              <Input id="username" type="text" {...register('username')} />
            </div>
            <div className="space-y-2">
              <Label htmlFor="password">Passowrd</Label>
              <Input id="password" type="password" {...register('password')} />
            </div>
            <Button disabled={isSubmitting} className="w-full" type="submit">
              Access App
            </Button>
          </form>
        </div>
      </div>
    </>
  )
}
