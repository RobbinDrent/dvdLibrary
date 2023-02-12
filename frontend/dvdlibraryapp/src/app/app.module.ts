import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DvdComponent } from './dvd/dvd.component';
import { DiscComponent } from './disc/disc.component';
import { FilmComponent } from './film/film.component';
import { DirectorComponent } from './director/director.component';
import { BxosetComponent } from './boxset/bxoset.component';
import { BoxsetComponent } from './boxset/boxset.component';

@NgModule({
  declarations: [
    AppComponent,
    DvdComponent,
    DiscComponent,
    FilmComponent,
    DirectorComponent,
    BxosetComponent,
    BoxsetComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
