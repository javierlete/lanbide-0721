import React from 'react';

export class ProductRow extends React.Component {
    render() {
        const product = this.props.product;

        return (
            <tr>
                <td>
                    <span>
                        {product.name}
                    </span>
                </td>
                <td>{product.price}</td>
            </tr>
        );
    }
}
