import React from 'react';
import { SearchBar } from './SearchBar';
import { ProductTable } from './ProductTable';

export class FilterableProductTable extends React.Component {
    constructor() {
        super();
        this.state = { filterText: 'ba', inStockOnly: true };
    }
    render() {
        const filterText = this.state.filterText;
        const inStockOnly = this.state.inStockOnly;
        return (
            <div>
                <SearchBar 
                    filterText={filterText} inStockOnly = {inStockOnly} />
                <ProductTable products={this.props.products} 
                    filterText={filterText} inStockOnly = {inStockOnly}/>
            </div>
        );
    }
}