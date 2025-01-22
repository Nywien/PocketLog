import {Component} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {TransactionService} from "../../services/transaction.service";
import {TransactionType} from "../../models/transaction-type";


@Component({
  selector: 'app-transaction-form',
  templateUrl: './transaction-form.component.html',
  styleUrls: ['./transaction-form.component.css']
})
export class TransactionFormComponent {

  transactionForm!: FormGroup;
  transactionTypes = Object.values(TransactionType);

  constructor(private formBuilder: FormBuilder,
              private transactionService: TransactionService) {
    this.transactionForm = this.formBuilder.group({
      type: [null, Validators.required],
      amount: [0, Validators.required],
      description: [null, Validators.required],
      transactionDate: [null, Validators.required]
    })
  }

  saveTransaction() {
    this.transactionService.addTransaction(this.transactionForm.value).subscribe({
      next: () => console.log('Transaction saved!'),
      error: (err) => console.error(err)
    });
  }

}
