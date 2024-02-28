import { useForm } from 'react-hook-form'
import { toast } from 'sonner'
import { z } from 'zod'

import { Button } from '@/components/ui/button'
import { Input } from '@/components/ui/input'
import { Label } from '@/components/ui/label'

const createForm = z.object({
  firstName: z.string(),
  middleName: z.string(),
  lastName: z.string(),
  email: z.string().email(),
  mobile: z.string(),
  address: z.string(),
  contractType: z.string(),
  startDate: z.string(),
  finishDate: z.string(),
  hoursType: z.string(),
  hoursPerWeek: z.number().int(),
})

type CreateForm = z.infer<typeof createForm>

export const EmployeeCreateForm = () => {
  const {
    register,
    handleSubmit,
    formState: { isSubmitting },
  } = useForm<CreateForm>()

  const handleCreate = async (data: CreateForm) => {
    try {
      console.log(data)

      await new Promise((resolve) => setTimeout(resolve, 2000))

      toast.success('Authentication successful.')
    } catch {
      toast.error('Error while trying to authenticate.')
    }
  }

  return (
    <form onSubmit={handleSubmit(handleCreate)} className="space-y-4">
      <div className="space-y-2">
        <Label htmlFor="firstName">First Name</Label>
        <Input id="firstName" type="text" {...register('firstName')} />
      </div>
      <div className="space-y-2">
        <Label htmlFor="middleName">Middle Name</Label>
        <Input id="middleName" type="text" {...register('middleName')} />
      </div>
      <div className="space-y-2">
        <Label htmlFor="lastName">Last Name</Label>
        <Input id="lastName" type="text" {...register('lastName')} />
      </div>
      <div className="space-y-2">
        <Label htmlFor="email">Email</Label>
        <Input id="email" type="email" {...register('email')} />
      </div>
      <div className="space-y-2">
        <Label htmlFor="mobile">Mobile</Label>
        <Input id="mobile" type="tel" {...register('mobile')} />
      </div>
      <div className="space-y-2">
        <Label htmlFor="address">Address</Label>
        <Input id="address" type="text" {...register('address')} />
      </div>
      <div className="space-y-2">
        <Label htmlFor="contractType">Contract Type</Label>
        <Input id="contractType" type="text" {...register('contractType')} />
      </div>
      <div className="space-y-2">
        <Label htmlFor="startDate">Start Date</Label>
        <Input id="startDate" type="text" {...register('startDate')} />
      </div>
      <div className="space-y-2">
        <Label htmlFor="finishDate">Finish Date</Label>
        <Input id="finishDate" type="text" {...register('finishDate')} />
      </div>
      <div className="space-y-2">
        <Label htmlFor="hoursType">Full-Time or Part-Time</Label>
        <Input id="hoursType" type="text" {...register('hoursType')} />
      </div>
      <div className="space-y-2">
        <Label htmlFor="hoursPerWeek">Hours Per Week</Label>
        <Input id="hoursPerWeek" type="number" {...register('hoursPerWeek')} />
      </div>
      <Button disabled={isSubmitting} className="w-full" type="submit">
        Create Employee
      </Button>
    </form>
  )
}
