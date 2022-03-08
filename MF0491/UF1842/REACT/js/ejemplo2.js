'use strict';

const e = React.createElement;

class LikeButton extends React.Component {
    constructor(props) {
        super(props);
        this.state = { liked: false };
    }

    render() {
        // if (this.state.liked) {
        //     return 'You liked this.';
        // }

        // return e(
        //     'button',
        //     { onClick: () => this.setState({ liked: true }) },
        //     'Like'
        // );

        return (
            <div>
                <button onClick={() => this.setState({ liked: true })}>
                    Like
                </button>
                <span>{this.state.liked ? 'VERDADERO' : 'FALSO'}</span>
            </div>
        );
    }
}

const domContainer = document.querySelector('#like_button_container');
ReactDOM.render(e(LikeButton), domContainer);
