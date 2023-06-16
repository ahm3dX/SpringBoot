export class Post {
  id: number;
  question: string;
  upvotes: number;
  downvotes: number;
  createdAt: Date;
  owner: any;
  constructor(
    id: number,
    question: string,
    upvotes: number,
    downvotes: number,
    createdAt: Date,
    owner: any
  )
  constructor(
    id: number,
    question: string,
    upvotes: number,
    downvotes: number,
    createdAt: Date,
    owner: any
  ) {
    this.id = id;
    this.question = question;
    this.upvotes = upvotes;
    this.downvotes = downvotes;
    this.createdAt = createdAt;
    this.owner = owner;
  }
}







