import {IComment} from '../shared/IComment';
import {IUser} from '../shared/IUser';


export interface IArticle {
  id: string;
  title: string;
  description: string;
  author: IUser;
  imageUrl: string;
  comments: IComment[];
  publishedOn: string;
  publishedIn: string;
}
