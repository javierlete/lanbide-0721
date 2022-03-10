import React from 'react';
import { ProductCategoryRow } from './ProductCategory';
import { ProductRow } from './ProductRow';

export class ProductTable extends React.Component {
    render() {
        return (
            <div>
                <pre>{ JSON.stringify(this.props.products) }</pre>
                <table>
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Price</th>
                        </tr>
                    </thead>
                    <tbody>
                        <ProductCategoryRow category="Cat1" />
                        <ProductRow product={{ name: 'Product1', price: 123.45 }} />
                        <ProductRow product={{ name: 'Product2', price: 23.45 }} />
                        <ProductRow product={{ name: 'Product3', price: 44 }} />
                        <ProductCategoryRow category="Cat2" />
                        <ProductRow product={{ name: 'Product4', price: 55 }} />
                        <ProductRow product={{ name: 'Product5', price: 66 }} />
                    </tbody>
                </table>
            </div>
        );
    }
}
