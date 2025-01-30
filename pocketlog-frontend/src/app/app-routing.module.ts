import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {TransactionFormComponent} from "./components/transaction-form/transaction-form.component";
import {TransactionListComponent} from "./components/transaction-list/transaction-list.component";

const routes: Routes = [
  {path: 'add', component: TransactionFormComponent},
  {path: 'all', component: TransactionListComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
