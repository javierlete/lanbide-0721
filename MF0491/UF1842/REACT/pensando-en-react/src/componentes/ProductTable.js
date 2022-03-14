import React from 'react';
import { ProductCategoryRow } from './ProductCategory';
import { ProductRow } from './ProductRow';

export class ProductTable extends React.Component {
    render() {
        const filterText = this.props.filterText;
        const inStockOnly = this.props.inStockOnly;

        const rows = [];
        let lastCategory = null;

        const products = this.props.products.filter(
            p => p.name.indexOf(filterText) >= 0 && (!inStockOnly || p.stocked));

        products.forEach((product) => {
            if (product.category !== lastCategory) {
                rows.push(
                    <ProductCategoryRow
                        category={product.category}
                        key={product.category} />
                );
            }
            rows.push(
                <ProductRow
                    product={product}
                    key={product.name} />
            );
            lastCategory = product.category;
        });

        return (
            <table class="mt-3 table table-striped table-hovered table-border">
                <thead class="table-dark">
                    <tr>
                        <th>Name</th>
                        <th>Price</th>
                    </tr>
                </thead>
                <tbody>{rows}</tbody>
            </table>
        );
    }
}