import {TransactionType} from "./transaction-type";

export interface TransactionListItemModel {
  type: TransactionType;
  amount: number;
  description: string;
  transactionDate: Date;
}
