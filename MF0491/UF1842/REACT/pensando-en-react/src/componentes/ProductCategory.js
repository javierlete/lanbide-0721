import React from 'react';

export class ProductCategoryRow extends React.Component {
    
    render() {
        const category = this.props.category;

        return (
            <tr className="table-secondary">
                <th colSpan="2">
                    {category}
                </th>
            </tr>
        );
    }
}