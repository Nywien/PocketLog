import {Component} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {TransactionService} from "../../services/transaction.service";
import {TransactionType} from "../../models/transaction-type";
import {validationHandler} from "../../utils/validationHandler";


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
      amount: [0, [Validators.required, Validators.min(1)]],
      description: [null, [Validators.required, Validators.minLength(5), Validators.maxLength(25)]],
      transactionDate: [null, Validators.required]
    })
  }

  saveTransaction() {
    this.transactionService.addTransaction(this.transactionForm.value).subscribe({
      error: err => {
        validationHandler(err, this.transactionForm);
      }
    });
  }

}
