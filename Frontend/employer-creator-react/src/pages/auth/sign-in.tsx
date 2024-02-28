import { Helmet } from 'react-helmet-async'
import { useForm } from 'react-hook-form'
import { toast } from 'sonner'
import { z } from 'zod'

import { Button } from '@/components/ui/button'
import { Input } from '@/components/ui/input'
import { Label } from '@/components/ui/label'

const signInForm = z.object({
  email: z.string().email(),
  password: z.string(),
})

type SignInForm = z.infer<typeof signInForm>

export const SignIn = () => {
  const {
    register,
    handleSubmit,
    formState: { isSubmitting },
  } = useForm<SignInForm>()

  const handleSignIn = async (data: SignInForm) => {
    try {
      console.log(data)

      await new Promise((resolve) => setTimeout(resolve, 2000))

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
              <Label htmlFor="email">Email</Label>
              <Input id="email" type="email" {...register('email')} />
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
