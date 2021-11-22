import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutusComponent } from './aboutus/aboutus.component';
import { ActivismComponent } from './activism/activism.component';
import { BodyComponent } from './body/body.component';
import { ContactComponent } from './contact/contact.component';
import { RescueCenterComponent } from './rescue-center/rescue-center.component';
import { SearchResultComponent } from './search-result/search-result.component';

const routes: Routes = [{
  path: "contact",
  component: ContactComponent
},{
  path: "",
  component: BodyComponent
},{
  path: "about-us",
  component: AboutusComponent
},{
  path: "activism",
  component: ActivismComponent
},
{
  path: "rescue-centers",
  component: RescueCenterComponent
},
{
  path: "wild-animal/:keyword",
  component: SearchResultComponent
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
