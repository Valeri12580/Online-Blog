import {IComment} from '../shared/IComment';


export interface IArticle {
  id: string;
  title: string;
  description: string;
  authorUsername: string;
  imageUrl: string;
  comments: IComment[];
  publishedOn: string;
  publishedIn: string;
}
