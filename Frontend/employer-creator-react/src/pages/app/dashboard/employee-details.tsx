import {
  DialogContent,
  DialogDescription,
  DialogHeader,
  DialogTitle,
} from '@/components/ui/dialog'
import { Table, TableBody, TableCell, TableRow } from '@/components/ui/table'

export const EmployeeDetails = () => {
  return (
    <DialogContent>
      <DialogHeader>
        <DialogTitle>Employee: 12</DialogTitle>
        <DialogDescription>employee details</DialogDescription>
      </DialogHeader>

      <div className="space-y-6">
        <Table>
          <TableBody>
            <TableRow>
              <TableCell className="text-muted-foreground">
                Full Name:
              </TableCell>
              <TableCell className="flex justify-end">
                Matheus Lincon Figueira de Andrade
              </TableCell>
            </TableRow>

            <TableRow>
              <TableCell className="w-full text-muted-foreground">
                Phone Number:
              </TableCell>
              <TableCell className="flex justify-end">123123123</TableCell>
            </TableRow>

            <TableRow>
              <TableCell className="text-muted-foreground">Email:</TableCell>
              <TableCell className="flex justify-end">
                matheuslincon@mail.com
              </TableCell>
            </TableRow>

            <TableRow>
              <TableCell className="text-muted-foreground">Address:</TableCell>
              <TableCell className="flex justify-end">
                38 Southlands Loop, Strathtulloh - Victoria, 3338 - Australia
              </TableCell>
            </TableRow>

            <TableRow>
              <TableCell className="text-muted-foreground">
                Contract Type:
              </TableCell>
              <TableCell className="flex justify-end">Permanent</TableCell>
            </TableRow>

            <TableRow>
              <TableCell className="text-muted-foreground">
                Start Date:
              </TableCell>
              <TableCell className="flex justify-end">23/10/2021</TableCell>
            </TableRow>

            <TableRow>
              <TableCell className="text-muted-foreground">
                Finish Date:
              </TableCell>
              <TableCell className="flex justify-end">23/08/2023</TableCell>
            </TableRow>

            <TableRow>
              <TableCell className="text-muted-foreground">
                Full-Time or Part-Time:
              </TableCell>
              <TableCell className="flex justify-end">Full-Time</TableCell>
            </TableRow>

            <TableRow>
              <TableCell className="text-muted-foreground">
                Hour per Week:
              </TableCell>
              <TableCell className="flex justify-end">40 hours</TableCell>
            </TableRow>
          </TableBody>
        </Table>
      </div>
    </DialogContent>
  )
}
