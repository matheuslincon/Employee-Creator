import { Helmet } from 'react-helmet-async'

import { Pagination } from '@/components/pagination'
import {
  Table,
  TableBody,
  TableHead,
  TableHeader,
  TableRow,
} from '@/components/ui/table'

import { EmployeeCreateDialog } from './employee-create-dialong'
import { EmployeeTableFilters } from './employee-table-filters'
import { EmployeeTableRow } from './employee-table-row'

export function Dashboard() {
  return (
    <>
      <Helmet title="Dashboard" />
      <div className="flex flex-col gap-4">
        <h1 className="text-3xl font-bold tracking-tight">Orders</h1>
        <div className="space-y-3">
          <div className="flex justify-between">
            <EmployeeTableFilters />
            <EmployeeCreateDialog />
          </div>

          <div className="rounded-md border">
            <Table>
              <TableHeader>
                <TableRow>
                  <TableHead className="w-[64px]"></TableHead>
                  <TableHead className="w-[40px]">ID</TableHead>
                  <TableHead className="w-[180px]">First Name</TableHead>
                  <TableHead className="w-[180px]">Last Name</TableHead>
                  <TableHead className="w-[180px]">Phone Number</TableHead>
                  <TableHead>Address</TableHead>
                  <TableHead className="w-[140px]">Contract Type</TableHead>
                  <TableHead className="w-[132px]"></TableHead>
                  <TableHead className="w-[164px]"></TableHead>
                </TableRow>
              </TableHeader>
              <TableBody>
                {Array.from({ length: 10 }).map((_, i) => {
                  return <EmployeeTableRow key={i} />
                })}
              </TableBody>
            </Table>
          </div>

          <Pagination pageIndex={0} totalCount={105} perPage={10} />
        </div>
      </div>
    </>
  )
}
