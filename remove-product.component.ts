import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/all/product';
import { ActivatedRoute } from '@angular/router';
import { ProductService } from 'src/app/service/product.service';
import { ProductCategory } from 'src/app/all/product-category';

@Component({
  selector: 'app-remove-product',
  templateUrl: './remove-product.component.html',
  styleUrls: ['./remove-product.component.css']
})
export class RemoveProductComponent implements OnInit {

  constructor(
    private productService: ProductService,
    private route: ActivatedRoute) { }


  product: Product = new Product();
  ngOnInit(): void {
    this.deleteProduct();
    
  }

 


  deleteProduct(){
    const theProductId: number = +this.route.snapshot.paramMap.get('id');
    this.productService.deleteProduct(theProductId).subscribe( data =>{
      window.location.replace('/products');
    }
    , error => console.log(error));
    window.location.replace('/products');
  }

}