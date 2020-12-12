import {IUser} from '../shared/IUser';
import {IComment} from '../shared/IComment';

export class IProduct {
  id: string;
  title: string;
  description: string;
  author: IUser;
  imageUrl: string;
  comments: IComment[];
  quantity: number;
  price: number;
}
