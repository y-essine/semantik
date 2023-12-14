import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { PagesListComponent } from "./components/pages-list/pages-list.component";
import { PagesAddComponent } from "./components/pages-list/pages-add/pages-add.component";

const routes: Routes = [
  { path: "", redirectTo: "home", pathMatch: "full" },
  { path: "pages", component: PagesListComponent },
  { path: "pages/add", component: PagesAddComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: true })],
  exports: [RouterModule],
})
export class AppRoutingModule {}
