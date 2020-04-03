import { Size } from './size';


export class SizeList {


    selVal: string;

    static values: Size[] = [

        {
            value: 'KB',
            viewValue: 'KB'
        },
        {
            value: 'MB',
            viewValue: 'MB'
        },
        {
            value: 'GB',
            viewValue: 'GB'
        }

    ];
}
