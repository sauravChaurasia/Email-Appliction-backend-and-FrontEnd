import { Component } from '@angular/core';
import {FormBuilder, Validators} from '@angular/forms';
import { HttpClient,HttpHeaders } from '@angular/common/http';
// import 'rxjs/add/operator/toPromise';
declare const enableEditMode:any;
declare const execCmd:any;
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'SeaQueanBoat';
  data:any;
  response:any;
  // emailForm:any;
  constructor(private fb:FormBuilder,private http:HttpClient){}
  ngOnInit(): void{
   enableEditMode();
  

   }
 
    emailForm=this.fb.group({
    emailId:[''],
    cc:[''],
    subject:[''],
    text:['']
  });
    send(){
    
    this.data=this.emailForm.value;
    console.log(this.data);
    let url="http://localhost:8080/send-mail";
    let httpOptions = {
      headers: new HttpHeaders({  
      'Content-Type': 'application/json' 
      })
    }
     this.http.post(url,this.data,httpOptions).subscribe(
      (res)=>console.log(res),
      (err)=>console.log(err)
     );
  }

}
