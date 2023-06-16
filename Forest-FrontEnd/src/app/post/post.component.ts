import { Component, OnInit } from '@angular/core';
import { Post } from 'app/models/post';
import { PostServiceService } from 'app/postService/post-service.service';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.scss']

})
export class PostComponent implements OnInit {
  // @ts-ignore
  post: Post = new Post(0);
  posts: Post[] = [];
  userPosts: Post[] = [];
  // @ts-ignore
  bestPost: Post = new Post();
  userScore: number = 0;
  error: string = '';

  constructor(private postService: PostServiceService) { }

  ngOnInit(): void {
    //this.getPosts();
    this.getBestPost();
    this.getMyPosts();
    this.getUserScore();
  }

  // getPosts(): void {
  //   this.postService.getPosts()
  //     .subscribe(posts => this.posts = posts);
  // }

  getBestPost(): void {
    this.postService.getBestPost()
      .subscribe(bestPost => this.bestPost = bestPost);
  }

  getMyPosts(): void {
    this.postService.getMyPosts()
      .subscribe(userPosts => this.userPosts = userPosts);
  }

  getUserScore(): void {
    this.postService.getUserScore(1) // Replace 1 with actual user id
      .subscribe(userScore => this.userScore = userScore);
  }

  addPost(): void {
    if (this.post.question.trim() === '') {
      this.error = 'Post content cannot be empty';
      return;
    }
    this.postService.addPost(this.post)
      .subscribe(post => {
        this.posts.unshift(post);
        // @ts-ignore
        this.post = new Post();
      });
  }

  upvotePost(post: Post): void {

      this.postService.upvotePost(post.id)
        .subscribe(success => {
          post.upvotes++;

        });

  }

  downvotePost(post: Post): void {

      this.postService.downvotePost(post.id)
        .subscribe(success => {
          if (success) {

            post.downvotes++;

          }
        });

  }
}
