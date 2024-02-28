import { Button } from '@/components/ui/button'
import { Dialog, DialogContent, DialogTrigger } from '@/components/ui/dialog'

import { EmployeeCreateForm } from './employee-create-form'

export const EmployeeCreateDialog = () => {
  return (
    <>
      <Dialog>
        <DialogTrigger asChild>
          <Button variant="default" size="xs">
            Create Employee
          </Button>
        </DialogTrigger>
        <DialogContent>
          <EmployeeCreateForm />
        </DialogContent>
      </Dialog>
    </>
  )
}
