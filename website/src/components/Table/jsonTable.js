import './jsonTable.css';

export default function JsonTable({theadData, tbodyData, buttons = (row, index) => {}}) {
    return (
        <table id='json-table'>
            <thead>
            <tr>
                {theadData.map(heading => {
                    return <th key={heading}>{heading}</th>
                })}
            </tr>
            </thead>
            <tbody>
            {tbodyData.map((row, index) => {
                return <tr key={index}>
                    {theadData.map((key, index) => {
                        return <td className='name' key={row[key]}>{row[key]}</td>
                    })}
                    {buttons(row, index)}
                </tr>;
            })}
            </tbody>
        </table>
    );
}