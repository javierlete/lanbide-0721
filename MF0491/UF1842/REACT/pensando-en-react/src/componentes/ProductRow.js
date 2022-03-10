import React from 'react';

export class ProductRow extends React.Component {
    render() {
        return (
            <tr>
                <td>
                    <span>
                        Nombre del producto
                    </span>
                </td>
                <td>Precio del producto</td>
            </tr>
        );
    }
}
