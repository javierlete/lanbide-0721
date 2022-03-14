import React from 'react';

export class ProductRow extends React.Component {
    render() {
        const product = this.props.product;
        
        return (
            <tr className={!product.stocked ? 'table-danger' : ''}>
                <td>{product.name}</td>
                <td>{product.price}</td>
            </tr>
        );
    }
}
