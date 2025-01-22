import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {TransactionCreationModel} from "../models/transaction-creation.model";
import {TransactionListItemModel} from "../models/transaction-list-item.model";

const BASE_URL = 'http://localhost:8080/api/transactions';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  constructor(private httpClient: HttpClient) {
  }

  addTransaction(data: TransactionCreationModel) {
    return this.httpClient.post<any>(BASE_URL, data);
  }

  getAllTransactions() {
    return this.httpClient.get<TransactionListItemModel[]>(BASE_URL);
  }
}
