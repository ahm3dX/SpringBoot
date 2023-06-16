import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Post } from '../models/post';


@Injectable({
  providedIn: 'root'
})
export class PostServiceService {

  private baseUrl = 'http://localhost:8089/Forest';

  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': ' Bearer '+localStorage.getItem('token')
    })
  };

  constructor(private http: HttpClient) {console.log(this.httpOptions.headers) }

  addPost(post: Post): Observable<Post> {
    return this.http.post<Post>(this.baseUrl + '/Post/addPost', post, this.httpOptions);
  }

  updatePost(id: number, content: string): Observable<Post> {
    return this.http.post<Post>(this.baseUrl + '/Post/UpdatePost/' + id, content, this.httpOptions);
  }

  getPost(id: number): Observable<Post> {
    return this.http.get<Post>(this.baseUrl + '/Post/GetPost/' + id, this.httpOptions);
  }

  getBestPost(): Observable<Post> {
    return this.http.get<Post>(this.baseUrl + '/Post/getBestPost', this.httpOptions);
  }

  getUserPosts(userId: number): Observable<Post[]> {
    return this.http.get<Post[]>(this.baseUrl + '/Post/GetUserPosts/' + userId, this.httpOptions);
  }

  getMyPosts(): Observable<Post[]> {
    return this.http.get<Post[]>(this.baseUrl + '/Post/GetMyPosts/', this.httpOptions);
  }

  getUserScore(userId: number): Observable<number> {
    return this.http.get<number>(this.baseUrl + '/Post/GetUserScore/' + userId, this.httpOptions);
  }

  upvotePost(id: number): Observable<boolean> {
    return this.http.post<boolean>(this.baseUrl + '/Post/UpVotePost/' + id, {}, this.httpOptions);
  }

  downvotePost(id: number): Observable<boolean> {
    return this.http.post<boolean>(this.baseUrl + '/Post/DownVotePost/' + id, {}, this.httpOptions);
  }
}
