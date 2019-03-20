import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

const url = 'http://localhost:8080/spring-training/api/products/';


@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products;
  
  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.http.get(url)
      .subscribe(data => this.products = data);
  }

}
