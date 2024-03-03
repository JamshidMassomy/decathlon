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
          {data?.map((row: any, rowIndex: number) => (
            <tr key={rowIndex}>
              {Object.keys(row).map(
                (key, cellIndex) =>
                  key !== 'error' && (
                    <td key={cellIndex} className="border px-4 py-2">
                      {row[key]}
                    </td>
                  )
              )}
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Table;
