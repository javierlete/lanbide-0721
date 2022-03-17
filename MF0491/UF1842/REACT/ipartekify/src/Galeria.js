import Ficha from "./Ficha";

import estilo from './Galeria.module.css';

export default function Galeria() {
    return (
        <div class={estilo.galeria}>
            <h2>Título galería</h2>
            <h3>Subtítulo galería</h3>
            
            <div class={estilo.fichas}>
                <Ficha />
                <Ficha />
                <Ficha />
                <Ficha />
                <Ficha />
                <Ficha />
                <Ficha />
            </div>
        </div>
    );
}