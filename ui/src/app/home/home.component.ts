import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RescueCenter } from '../model/rescue-center';
import { catchError, map, tap } from 'rxjs/operators';
import { ImageClassification } from '../model/ImageClassfication';
import { WildAnimal } from '../model/wild-animal';
import { Router } from '@angular/router';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  constructor(private http: HttpClient,
    private router: Router) { }

  private listRescueCentersUrl =
    'https://calm-citadel-33738.herokuapp.com/rescue-center/list';

  centers: RescueCenter[] | undefined;
  fileToUpload: File | null = null;
  imageResponse: ImageClassification | undefined;

  keyword: string | any;

  ngOnInit(): void {
    this.getCenters();
    this.keyword = "";
  }

  getCenters(): void {
    this.listCenters().subscribe(
      (centers) => (this.centers = centers.slice(0, 3))
    );
  }

  handleFileInput(event: any) {
    let file: File = event.target.files[0];
    let formData: FormData = new FormData();
    formData.append('file', file, file.name);
    this.uploadFile(formData).subscribe(
      (response) => {
        console.log(response)
        this.keyword = this.getAnimal(response.label);
      }
    );
  }

  searchAnimal() {
    this.router.navigate(['/wild-animal/', this.keyword])
  }

  searchChanged(event: any) {
    this.keyword = event.target.value;
  }

  listCenters(): Observable<RescueCenter[]> {
    return this.http
      .get<RescueCenter[]>(this.listRescueCentersUrl)
      .pipe(tap((_) => this.log('fetched centers')));
  }

  uploadFile(formData: FormData): Observable<ImageClassification> {
    let endpoint = 'https://fc08-58-187-77-4.ngrok.io/uploads';
    return this.http
      .post<ImageClassification>(endpoint, formData)
      .pipe(tap((_) => this.log('fetched centers')));
  }

  private log(message: string) {
    console.log(`CenterService: ${message}`);
  }

  private getAnimal(animal: string) {
    switch (animal) {
      case "gallina":
        return "chicken";
      case "cavallo":
        return "horse";
      case "elefante":
        return "elephant";
      case "farfalla":
        return "butterfly";
      case "scoiattolo":
        return "squirrel";
      default:
        return "";
    }
  }
}
