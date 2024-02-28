import { Cog, Delete, Search } from 'lucide-react'

import { Button } from '@/components/ui/button'
import { Dialog, DialogTrigger } from '@/components/ui/dialog'
import { TableCell, TableRow } from '@/components/ui/table'

import { EmployeeDetails } from './employee-details'

export const EmployeeTableRow = () => {
  return (
    <TableRow>
      <TableCell>
        <Dialog>
          <DialogTrigger asChild>
            <Button variant="outline" size="xs">
              <Search className="h-3 w-3" />
              <span className="sr-only">Employee details</span>
            </Button>
          </DialogTrigger>
          <EmployeeDetails />
        </Dialog>
      </TableCell>
      <TableCell className="font-mono text-xs font-medium">1</TableCell>
      <TableCell className="text-foreground">Matheus Lincon</TableCell>
      <TableCell className="text-foreground">Figueira de Andrade</TableCell>
      <TableCell className="text-foreground">+61433425165</TableCell>
      <TableCell className="font-medium">
        38 Southlands Loop, Strathtulloh - Victoria, 3338 - Australia
      </TableCell>
      <TableCell className="font-medium">Permanent</TableCell>
      <TableCell>
        <Button variant="outline" size="xs">
          <Cog className="mr-2 h-4 w-4" />
          Edit
        </Button>
      </TableCell>
      <TableCell>
        <Button variant="ghost" size="xs">
          <Delete className="mr-2 h-4 w-4" />
          Delete
        </Button>
      </TableCell>
    </TableRow>
  )
}
