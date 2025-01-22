import {Component, OnInit} from '@angular/core';
import {TransactionListItemModel} from "../../models/transaction-list-item.model";
import {TransactionService} from "../../services/transaction.service";

@Component({
  selector: 'app-transaction-list',
  templateUrl: './transaction-list.component.html',
  styleUrls: ['./transaction-list.component.css']
})
export class TransactionListComponent implements OnInit {

  transactions: TransactionListItemModel[] = [];
  displayedColumns: string[] = ['type', 'amount', 'description', 'transactionDate'];

  constructor(private transactionService: TransactionService) {
  }

  listTransactions() {
    this.transactionService.getAllTransactions().subscribe(
      (transactionList: TransactionListItemModel[]) => {
        this.transactions = transactionList;
      }
    )
  }

  ngOnInit(): void {
    this.listTransactions();
  }

}
