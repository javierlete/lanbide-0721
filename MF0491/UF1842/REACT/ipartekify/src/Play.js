import { solid } from '@fortawesome/fontawesome-svg-core/import.macro'; // <-- import styles to be used
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import './Play.css';

export default function Play() {
    return (
        <div class="play">
            <FontAwesomeIcon icon={solid('play')} />
        </div>
    );
}
