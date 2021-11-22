import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { WildAnimal } from '../model/wild-animal';

@Component({
  selector: 'app-search-result',
  templateUrl: './search-result.component.html',
  styleUrls: ['./search-result.component.css']
})
export class SearchResultComponent implements OnInit {
  wildAnimal: WildAnimal | undefined;
  searchAnimalUrl =
    'https://calm-citadel-33738.herokuapp.com/wild-animal/search-by-text?keyword=';
  constructor(private http: HttpClient,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.searchAnimal();
  }

  searchAnimal() {
    const keyword = this.route.snapshot.params['keyword'];
    console.log('keyword ' + keyword);
    this.http
      .get<WildAnimal>(this.searchAnimalUrl + keyword)
      .subscribe((animal) => (this.wildAnimal = animal));

    console.log('haha '+this.wildAnimal)
  }
}
