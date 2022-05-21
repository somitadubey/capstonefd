import { Product } from './product';

export class CartItem {

    id: string;
    name: string;
    imageUrl: string;
    price: number;

    quantity: number;

    constructor(p: Product) {
        this.id = p.id;
        this.name = p.name;
        this.imageUrl = p.imageUrl;
        this.price = p.price;

        this.quantity = 1;
    }
}