import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { RescueCenter } from '../model/rescue-center';
import { catchError, map, tap } from 'rxjs/operators';

@Component({
  selector: 'app-rescue-center',
  templateUrl: './rescue-center.component.html',
  styleUrls: ['./rescue-center.component.css']
})
export class RescueCenterComponent implements OnInit {
  private listRescueCentersUrl = 'https://calm-citadel-33738.herokuapp.com/rescue-center/list';
  constructor(private http : HttpClient){
  }
  centers: RescueCenter[] | undefined;
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  ngOnInit(): void {
    this.getCenters();
    console.log(this.getCenters());
  }

  getCenters(): void {
    this.listCenters()
    .subscribe(centers => this.centers = centers);
  }

  listCenters(): Observable<RescueCenter[]> {
    return this.http.get<RescueCenter[]>(this.listRescueCentersUrl)
    .pipe(
      tap(_ => this.log('fetched centers')),
    );
  }

  private log(message: string) {
    console.log(`CenterService: ${message}`);
  }
}
