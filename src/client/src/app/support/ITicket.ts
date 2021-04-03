import {IUser} from '../shared/IUser';

export interface ITicket {
  email: string;
  subject: string;
  message: string;
  isResolved: boolean;
  createdOn: string;
  resolvedBy: IUser;
}
