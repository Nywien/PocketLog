import {TransactionType} from "./transaction-type";

export interface TransactionCreationModel {

  type: TransactionType;
  amount: number;
  description: string;
  transactionDate: Date;
}
