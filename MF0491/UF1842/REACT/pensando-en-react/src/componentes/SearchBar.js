import React from 'react';

export class SearchBar extends React.Component {
    render() {
        const filterText = this.props.filterText;
        const inStockOnly = this.props.inStockOnly;

        return (
            <form>
                <input class="form-control" type="text" placeholder="Search..." value={filterText}
                    onChange={(e) => this.props.filterTextChanged(e.target.value)} />
                <p class="form-check mt-3">
                    <input id="in-stock" class="form-check-input" type="checkbox" checked={inStockOnly}
                        onChange={(e) => this.props.inStockOnlyChanged(e.target.checked)} />
                    <label class="form-check-label" for="in-stock">Only show products in stock</label>
                </p>
            </form>
        );
    }
}
