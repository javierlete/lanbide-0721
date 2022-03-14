import React from 'react';

export class ProductRow extends React.Component {
    render() {
        const product = this.props.product;
        
        return (
            <tr className={!product.stocked ? 'table-danger' : 'table-success'}>
                <td>{product.name}</td>
                <td class="text-end">{product.price}</td>
            </tr>
        );
    }
}
