import React from 'react';
import { SearchBar } from './SearchBar';
import { ProductTable } from './ProductTable';

export class FilterableProductTable extends React.Component {
    constructor() {
        super();
        this.state = { filterText: '', inStockOnly: false };
    }

    handleFilterTextChanged(text) {
        this.setState({
            filterText: text
        });
    }

    handleInStockOnlyChanged(checked) {
        this.setState({
            inStockOnly: checked
        });
    }

    render() {
        const filterText = this.state.filterText;
        const inStockOnly = this.state.inStockOnly;

        return (
            <div>
                <SearchBar
                    filterText={filterText} inStockOnly={inStockOnly}
                    filterTextChanged={(text) => this.handleFilterTextChanged(text)}
                    inStockOnlyChanged={(checked) => this.handleInStockOnlyChanged(checked)} />
                <ProductTable products={this.props.products}
                    filterText={filterText} inStockOnly={inStockOnly} />
            </div>
        );
    }
}