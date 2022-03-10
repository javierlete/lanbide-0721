import React from 'react';
import { ProductCategoryRow } from './ProductCategory';
import { ProductRow } from './ProductRow';

export class ProductTable extends React.Component {
    render() {
        return (
            <table>
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Price</th>
                    </tr>
                </thead>
                <tbody>
                    <ProductCategoryRow />
                    <ProductRow />
                    <ProductRow />
                    <ProductRow />
                    <ProductCategoryRow />
                    <ProductRow />
                    <ProductRow />
                </tbody>
            </table>
        );
    }
}
