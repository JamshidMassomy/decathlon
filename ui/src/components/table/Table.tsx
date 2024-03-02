import React from 'react';
import './styles.scss';

const Table = ({ columns, data }) => {
  return (
    <div className="overflow-x-auto">
      <table className="table-auto w-full border-collapse border custom-tbl">
        <thead>
          <tr>
            {columns.map((column, index) => (
              <th key={index} className="border px-4 py-2">
                {column}
              </th>
            ))}
          </tr>
        </thead>
        <tbody>
          {data.map((row: any[], rowIndex: React.Key) => (
            <tr key={rowIndex}>
              {row.map((cell, cellIndex) => (
                <td key={cellIndex} className="border px-4 py-2">
                  {cell}
                </td>
              ))}
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Table;
