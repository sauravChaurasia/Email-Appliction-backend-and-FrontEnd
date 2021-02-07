import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
// import { EditorModule } from '@tinymce/tinymce-angular';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
// import { BoatsComponent } from './boats/boats.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [
    AppComponent,
    // BoatsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,FormsModule,ReactiveFormsModule,HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
