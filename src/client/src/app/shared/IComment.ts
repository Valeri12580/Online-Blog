import {IUser} from './IUser';

export interface IComment {
  datePublishedOn: string;
  timePublishedOn: string;
  id: string;
  description: string;
  author: IUser;
  publishedOn: string;
}
