import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Activism, ActivismResponse } from '../model/activism';
import { catchError, map, tap } from 'rxjs/operators';

@Component({
  selector: 'app-activism',
  templateUrl: './activism.component.html',
  styleUrls: ['./activism.component.css']
})
export class ActivismComponent implements OnInit {
  private listActivismList = 'https://fc08-58-187-77-4.ngrok.io/crawler';

  constructor(private http:HttpClient) { }

  activism: Activism[] | undefined;
  count: number | undefined;

  ngOnInit(): void {
    this.getActivism();
  }

  listActivism(): Observable<ActivismResponse> {
    return this.http.get<ActivismResponse>(this.listActivismList)
    .pipe(
      tap(_ => this.log('fetched centers')),
    );
  }

  getActivism(): void {
    this.listActivism()
    .subscribe(activism => this.activism = activism.data);
  }

  
  private log(message: string) {
    console.log(`CenterService: ${message}`);
  }

}
