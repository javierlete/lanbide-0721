import React from 'react';

export class SearchBar extends React.Component {
    render() {
        const filterText = this.props.filterText;
        const inStockOnly = this.props.inStockOnly;

        return (
            <form>
                <input type="text" placeholder="Search..." value={filterText}
                    onChange={(e) => this.props.filterTextChanged(e.target.value)} />
                <p>
                    <input type="checkbox" checked={inStockOnly}
                        onChange={(e) => this.props.inStockOnlyChanged(e.target.checked)} />
                    
                    Only show products in stock
                </p>
            </form>
        );
    }
}
