import estilo from './Ficha.module.css';
import Play from './Play';

export default function Ficha() {
    return (
        <div class={estilo.ficha}>
            <h4>Título ficha</h4>
            <h5>Subtítulo ficha</h5>

            <img src={'https://picsum.photos/150?' + Math.random()} alt="" />

            <Play />
        </div>
    );
}