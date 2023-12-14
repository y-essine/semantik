import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { FormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { PagesListComponent } from "./components/pages-list/pages-list.component";
import { PagesAddComponent } from "./components/pages-list/pages-add/pages-add.component";

@NgModule({
  declarations: [AppComponent, PagesListComponent, PagesAddComponent],
  imports: [BrowserModule, AppRoutingModule, FormsModule, HttpClientModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
